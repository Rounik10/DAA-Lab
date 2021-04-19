package day_final;

import java.util.ArrayList;
import java.util.Scanner;

class Term {
	double cof;
	int pow;
	Term next;
	Term(double cof, int pow) {
		this.cof = cof;
		this.pow = pow;
		this.next = null;
	}
	@Override
	public String toString() {
		return "("+ cof +"*x^"+pow +")";
	}
}

class Polynomial {
	Term head;
	Term tail;
	int size;
	private boolean imaginary;
	
	Polynomial() {
		head = tail = null;
		this.size = 0;
	}
	
	Polynomial(int degree, double[] cofArray) {
		head = tail = null;
		size = 0;
		if(cofArray.length < degree+1) {
			System.err.println("Validate Array");
			System.exit(-1);
		}
		for(int i=degree; i>=0; i--) {
			addTerm(cofArray[degree-i], i);
		}
	}
	
	void addTerm(Term newTerm) {
		if(head == null) {
			head = newTerm;
			tail = head;
		} else {
			tail.next = newTerm;
			tail = tail.next;
		}
		size+=1;
	}
	
	void addTerm(double cof, int pow) {
		Term newTerm = new Term(cof, pow);
		if(head == null) {
			head = newTerm;
			tail = head;
		} else {
			tail.next = newTerm;
			tail = tail.next;
		}
		size+=1;
	}
	
	boolean isEmpty() {
		return size == 0;
	}
	
	Polynomial substract(Polynomial p1, Polynomial p2) {
		Polynomial ans = new Polynomial();
		Term t1 = p1.head;
		Term t2 = p2.head;
		
		while(t1!=null && t2!=null) {
			if(t1.pow == t2.pow) {
				Term temp = new Term(t1.cof-t2.cof,t1.pow);
				if(temp.cof != 0) ans.addTerm(temp);
				t1 = t1.next;
				t2 = t2.next;
			}
			else {
				if(t1.pow > t2.pow) {
					ans.addTerm(t1);
					t1 = t1.next;
				}
				else {
					t2.cof *=-1;
					ans.addTerm(t2);
					t2 = t2.next;
				}
			}
		}
		while(t1 != null) {
			ans.addTerm(t1);
			t1=t1.next;
		}
		while(t2 != null) {
			t2.cof *= -1;
			ans.addTerm(t2);
			t2=t2.next;
		}
		return ans;
	}
	
	void show() {
		Term temp = head;
		while(temp != null && temp.next!=null) {
			System.out.print(temp+" + ");
			temp = temp.next;
		}
		System.out.println(temp);
	}

	Polynomial differentiate() {
		Polynomial diff = new Polynomial();
		Term temp = this.head;
		while(temp!=null) {
			Term toAdd = new Term(temp.cof*(temp.pow),
									temp.pow-1);
			if(toAdd.cof != 0) {
				diff.addTerm(toAdd);
			}
			temp = temp.next;
		}
		return diff;
	}
	
	private Polynomial copy(Polynomial polynomial) {
		Polynomial copy = new Polynomial();
		var temp = polynomial.head;
		while(temp != null) {
			copy.addTerm(temp.cof, temp.pow);
			temp = temp.next;
		}
		return copy;
	}

	Polynomial multiplyTerm(Polynomial p1, Term term) {
		Polynomial ans = new Polynomial();
		Term temp = p1.head;
		while(temp!=null) {
			int pow = temp.pow + term.pow;
			double cof = temp.cof * term.cof;
			ans.addTerm(new Term(cof, pow));
			temp = temp.next;
		}
		return ans;
	}
	
	double getOneRoot() {
		Polynomial diff = this.differentiate();
		double x = 0;
		while(diff.f(x)==0) x+=0.001;
		double h = f(x) / diff.f(x);
		
		int MAX_ITR = 100000, itr = 0;
        
		while (Math.abs(h) >= 0.00001 && itr++<MAX_ITR) {
            h = f(x) / diff.f(x);
            x = x - h;
        }
		
		if(itr>=MAX_ITR) {
			// System.err.println("Imaginary Roots!");
			imaginary = true;
			return -1;
		}
		return Math.round(x * 100.0) / 100.0;
	}
	
	double f(double x) {
		Term temp = head;
		double val = 0;
		while(temp!=null) {
			val += temp.cof * Math.pow(x, temp.pow);
			temp = temp.next;
		}
		return val;
	}

	Polynomial divide(Polynomial poly1, Polynomial poly2) {
		Polynomial rem = copy(poly1), quo = new Polynomial();
		Polynomial p2Clone = copy(poly2);
		while(!rem.isEmpty() && rem.head.pow >= p2Clone.head.pow) {
			double cof = rem.head.cof / p2Clone.head.cof;
			int pow = rem.head.pow - p2Clone.head.pow;
			Term mul = new Term(cof, pow);
			quo.addTerm(mul);
			Polynomial sub = multiplyTerm(poly2, mul);
			rem = substract(rem, sub);
		}
		return quo;
	}
	
	ArrayList<Double> getRoots() {
		if(this.head == null) {
			return new ArrayList<>();
		}
		if(this.head.pow == 1) {
			double ans;
			if(this.head.next == null) {
				ans = 0;
			}
			else {
				ans = -1*this.head.next.cof / this.head.cof ;
			}
			ArrayList<Double> list = new ArrayList<>();
			list.add(ans);
			return list;
		}
		ArrayList<Double> ans = new ArrayList<>();
		double firstRoot = this.getOneRoot();
		
		if(imaginary) {
			imaginary = false;
			return new ArrayList<>();
		}
		ans.add(firstRoot);

		Polynomial rem = new Polynomial();
		rem.addTerm(new Term(1,1));
		rem.addTerm(new Term(-1*firstRoot,0));
		
		ArrayList<Double> roots = divide(this, rem).getRoots();
		
		for(double root  : roots) {
			ans.add(root);
		}
		return ans;
	}
}

public class PolynomialSolver {
	
	static Polynomial polynomial;
	
	static void takeUserInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of terms in the polynomial: ");
		int terms = sc.nextInt();
		polynomial = new Polynomial();
		
		for(int i=1; i<=terms; i++) {
			System.out.println("For the term no "+i+": ");
			System.out.println("Enter Cofficient: ");
			double cof = sc.nextDouble();	
			System.out.println("Enter Power:");
			int pow = sc.nextInt();
			polynomial.addTerm(cof, pow);
		}
		sc.close();
	}
	
	static void degreeN() {
		// x^{10}-55x^9+1320x^8-18150x^7+157773x^6-902055x^5+ 3416930x^4-8409500x^3+12753576x^2-10628640x+3628800
		int degree=10;
		double[] cofArr = {1,-55,1320,-18150,157773,-902055,3416930,-8409500,12753576,-10628640,3628800};
		polynomial = new Polynomial(degree,cofArr);
	}
	
	static void printRoots() {
		ArrayList<Double> realRoots = polynomial.getRoots();
		if(realRoots.isEmpty()) {
			System.err.println("All roots are Imaginary.");
		}
		else {
			System.out.println("Real Roots: ");
			System.out.println(realRoots);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Name: Rounik Prashar");
		System.out.println("Roll No: BTECH/60023/19\n");
		//degreeN();
		takeUserInput();
		System.out.println("Polynomial: ");
		polynomial.show();
		printRoots();
	}
}
//how to convert double to int
//Newton's method
//return (int)Math.sqrt(x);
class Solution{
	public int mySqrt(int x){
		double temp = x;
		while(temp * temp > x)
			temp = (temp + x / temp ) / 2;
		return (int)temp;
	}
}

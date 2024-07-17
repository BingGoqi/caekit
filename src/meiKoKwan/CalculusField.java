/**  
 * @Title: CalculusField.java
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-15 07:50:11 
 */ 

package meiKoKwan;

/**  
 * @ClassName: CalculusField
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-15 07:50:11 
 */

public interface CalculusField<T> extends NumField<T> {
	T scalb(int n);
	T ulp();
	T hypot(T y);
	T reciprocal();
	T sqrt();
	T cbrt();
	T rootN(int n);
	T pow(double p);
	T pow(int n);
	T pow(T e);
	T exp();
	T expm1();
	T log();
	T log1p();
	T log10();
	T cos();
	T sin();
	T tan();
	T acos();
	T asin();
	T atan();
	T atan2(T x);
	T cosh();
	T sinh();
	T tanh();
	T acosh();
	T asinh();
	T atanh();
	T toDegrees();
	T toRadians();
	T ceil();
	T floor();
	T rint();
	T remainder(double a);
	T remainder(T a);
	T sign();
}

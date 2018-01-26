//модель для храннения связки любых двух типов переменных.
//с возможностью их установки и считывания
package com.yss1.one.util;

	public class Twix<T1,T2>{
		public Twix(T1 key, T2 val) {
			this.key = key;
			this.val = val;
		}
		public T1 getFirst() {
			return key;
		}
		public T2 getSecond() {
			return val;
		}
		private T1 key;
		private T2 val;
		
	
}

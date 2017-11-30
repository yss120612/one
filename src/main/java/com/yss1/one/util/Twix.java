package com.yss1.one.util;

	public class Twix<T1,T2>{
		public Twix(T1 key, T2 val) {
			this.key = key;
			this.val = val;
		}
		public T1 getKey() {
			return key;
		}
		public T2 getVal() {
			return val;
		}
		private T1 key;
		private T2 val;
		
	
}

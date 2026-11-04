package com.rays.common;

import java.util.HashMap;
import java.util.Map;

public class Response {

		public static final String INPUT_ERROR = "inputerror";
		public static final String MESSAGE = "message";
		public static final String DATA = "data";

		private Map<Object, Object> result = new HashMap<Object, Object>();
		public boolean success = false;

		public Response() {

		}

		public Response(boolean success) {
			this.success = success;
		}

		public Map<Object, Object> getResult() {
			return result;
		}

		public void setResult(Map<Object, Object> result) {
			this.result = result;
		}

		public boolean isSuccess() {
			return success;
		}

		public void setSuccess(boolean success) {
			this.success = success;
		}

		public void addInputError(Object errors) {
			result.put(INPUT_ERROR, errors);
		}

		public void addData(Object data) {
			result.put(DATA, data);
		}

		public void addMessage(Object message) {
			result.put(MESSAGE, message);
		}

		public void addResult(String key, Object value) {
			result.put(key, value);
		}

	}



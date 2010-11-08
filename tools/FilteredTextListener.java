package hotciv.tools;

import org.junit.runner.notification.Failure;
import org.junit.internal.TextListener;

/**
 * This is a stacktrace-filtered version of 
 * org.junit.internal.TextListener.
 * It would have been nice if we were able to implement
 * this class as a Decorator, but the only method we
 * want to "decorate" has protected access in TextListener.
 * Therefore this quick extends hack.
 */

public class FilteredTextListener extends TextListener{
	@Override
	protected void printFailureTrace(Failure failure) {
		String []lines = failure.getTrace().split("\\n");
		StringBuilder sb = new StringBuilder();
		for(String line:lines) {
			if(!filterOut(line))
				sb.append(line).append("\n");
		}
		System.out.println(sb.toString());
	}

	private boolean filterOut(String line) {
		return line.contains("junit.Assert") ||
			line.contains(".reflect") ||
			line.contains(".runner") ||
			line.contains(".tools");
	}
}
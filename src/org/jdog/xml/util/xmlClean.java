/*
 * xmlClean.java
 *
 * Written By: Ted Elwartowski
 * 
 * xmlClean cleans XML data of special characters (&"'<>)
 */

package org.jdog.xml.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class xmlClean {

	public xmlClean() {
	}

	public String clean(String in) {
		if (in != null) {
			in = cleanAmp(in);
			in = cleanApos(in);
			in = cleanQuot(in);
			in = cleanLt(in);
			in = cleanGt(in);
			in = cleanNewLine(in);
		}
		return in;
	}

	public String clean(String in, String[] chars) {
		if (in != null && chars.length > 0) {
			for (int i = 0; i < chars.length; i++) {
				if (chars[i].equals("&"))
					in = cleanAmp(in);
				if (chars[i].equals("'"))
					in = cleanApos(in);
				if (chars[i].equals("<"))
					in = cleanLt(in);
				if (chars[i].equals(">"))
					in = cleanGt(in);
				if (chars[i].equals("\""))
					in = cleanQuot(in);
				if (chars[i].equals("\\n"))
					in = cleanNewLine(in);
				if (chars[i].equals("\\r"))
					in = cleanNewLine(in);
			}
		}
		return in;
	}

	public String cleanApos(String in) {
		if (in != null) {
			Pattern p = Pattern.compile("\\'", Pattern.CASE_INSENSITIVE
					| Pattern.MULTILINE);
			Matcher m = p.matcher(in);
			in = m.replaceAll("&apos;");
		}

		return in;
	}

	public String cleanQuot(String in) {
		if (in != null) {
			Pattern p = Pattern.compile("\"", Pattern.CASE_INSENSITIVE
					| Pattern.MULTILINE);
			Matcher m = p.matcher(in);
			in = m.replaceAll("&quot;");
		}

		return in;
	}

	public String cleanLt(String in) {
		if (in != null) {
			Pattern p = Pattern.compile("\\<", Pattern.CASE_INSENSITIVE
					| Pattern.MULTILINE);
			Matcher m = p.matcher(in);
			in = m.replaceAll("&lt;");
		}

		return in;
	}

	public String cleanGt(String in) {
		if (in != null) {
			Pattern p = Pattern.compile("\\>", Pattern.CASE_INSENSITIVE
					| Pattern.MULTILINE);
			Matcher m = p.matcher(in);
			in = m.replaceAll("&gt;");
		}

		return in;
	}

	private String cleanAmp(String in) {
		if (in != null) {
			Pattern p = Pattern.compile("\\&", Pattern.CASE_INSENSITIVE
					| Pattern.MULTILINE);
			Matcher m = p.matcher(in);
			in = m.replaceAll("&amp;");
		}

		return in;
	}

	public String cleanNewLine(String in) {
		if (in != null) {
			Pattern p = Pattern.compile("[\\n\\r]", Pattern.CASE_INSENSITIVE
					| Pattern.MULTILINE);
			Matcher m = p.matcher(in);
			in = m.replaceAll("");
		}

		return in;
	}

}

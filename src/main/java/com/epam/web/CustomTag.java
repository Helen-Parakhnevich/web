package com.epam.web;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;


public class CustomTag extends TagSupport {

    protected Object value;
    protected Locale locale;
    protected String pattern;

    public CustomTag() {
        super();
        init();
    }

    private void init() {
        value = null;
        locale = null;
        pattern = null;
    }

    public void setLocale(Object loc) throws JspTagException {

        if (loc == null) {
            this.locale = null;
        } else if (loc instanceof Locale) {
            this.locale = (Locale) loc;
        } else if (loc instanceof String) {
            String[] language_country = ((String) loc).split("_");
            String language = language_country[0];
            String country = language_country[1];
            this.locale = new Locale(language, country);
        } else {
            throw new JspTagException("Can only accept Locale or String objects.");
        }
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public int doEndTag() throws JspException {

        if (value == null) {
            return EVAL_PAGE;
        }

        DateTimeFormatter dataFormatter;
        JspWriter out = pageContext.getOut();

        if (pattern != null) {
            dataFormatter = DateTimeFormatter.ofPattern(pattern);
        } else {
            dataFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        }

        if (locale == null) {
            locale = new Locale("en", "US");
        }
        if (locale != null) {
            dataFormatter = dataFormatter.withLocale(locale);
        }

        dataFormatter = dataFormatter.withZone(ZoneId.systemDefault());

        String formatted;
        try {
            formatted = dataFormatter.format((TemporalAccessor) LocalDateTime.parse((String)value));
        } catch (Exception e) {
            throw new JspException("Error formatting date", e);
        }
        try {
            out.print(formatted);
        } catch (Exception e) {
            throw new JspTagException(e.toString(), e);
        }
        return SKIP_BODY;
    }

}



package de.conio.gatewayservice;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class SimpleFilter extends ZuulFilter {

	// There are three types of filters: pre, route and post and each set of filters
	// is executed in that order (ie all pre's first, routes 2nd and post's 3rd).
	private static Logger LOGGER = LoggerFactory.getLogger(SimpleFilter.class);

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		LOGGER.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));

		return null;
	}

}
package com.springcloud.shop.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class CustomFilter extends ZuulFilter {

	private static Logger logger = LoggerFactory.getLogger(CustomFilter.class);
	
	
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext currentContext = RequestContext.getCurrentContext();
		HttpServletRequest request = currentContext.getRequest();
		logger.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL()));
		
		// no meaning for retun value
		return null;
	}

	@Override
	public String filterType() {
		// pre, post, route, error
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}

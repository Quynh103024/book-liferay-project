package com.hehehe.bookrepository.portlet.author;

import com.hehehe.bookrepository.portlet.constants.BookPortletKeys;
import com.hehehe.servicebuilder.service.AuthorService;
import com.hehehe.util.comparator.AuthorNameComparator;
import javax.portlet.Portlet;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
@Component(immediate = true, property = { 
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", 
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=AuthorModule", 
		"javax.portlet.init-param.template-path=/author/",
		"javax.portlet.init-param.view-template=/author/view.jsp",
		"javax.portlet.name=" + BookPortletKeys.AUTHORPORTLET, 
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"}, 
		service = Portlet.class)
public class AuthorModulePortlet extends MVCPortlet {
	@Reference
	private AuthorService authorService;
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		int delta = ParamUtil.getInteger(renderRequest, "delta");
		int cur = ParamUtil.getInteger(renderRequest, "cur");
		int from = delta * (cur - 1);
		int to = delta == 0 ? 9 : delta * cur;
		renderRequest.setAttribute("totalAuthor", authorService.getAuthorCount());
		renderRequest.setAttribute("entries", authorService.getAuthors(from, to, new AuthorNameComparator()));
		super.doView(renderRequest, renderResponse);
	}
}

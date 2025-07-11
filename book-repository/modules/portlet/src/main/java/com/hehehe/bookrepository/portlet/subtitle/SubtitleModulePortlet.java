package com.hehehe.bookrepository.portlet.subtitle;

import com.hehehe.bookrepository.portlet.constants.BookPortletKeys;
import com.hehehe.servicebuilder.service.SubtitleService;
import com.hehehe.util.comparator.SubtitleNameComparator;
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
		"javax.portlet.display-name=SubtitleModule", 
		"javax.portlet.init-param.template-path=/subtitle/",
		"javax.portlet.init-param.view-template=/subtitle/view.jsp",
		"javax.portlet.name=" + BookPortletKeys.SUBTITLEPORTLET, 
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"}, 
		service = Portlet.class)
public class SubtitleModulePortlet extends MVCPortlet{
	@Reference
    private SubtitleService subtitleService;
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		int delta = ParamUtil.getInteger(renderRequest, "delta");
		int cur = ParamUtil.getInteger(renderRequest, "cur");
		int from = delta * (cur - 1);
		int to = delta == 0 ? 9 : delta * cur;
		renderRequest.setAttribute("totalSubtitle", subtitleService.getSubtitlesCount());
		renderRequest.setAttribute("entries", subtitleService.getSubtitles(from, to, new SubtitleNameComparator()));
		super.doView(renderRequest, renderResponse);
	}
}

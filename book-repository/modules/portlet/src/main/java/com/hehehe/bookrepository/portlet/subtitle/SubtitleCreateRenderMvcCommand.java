package com.hehehe.bookrepository.portlet.subtitle;
import com.hehehe.bookrepository.portlet.constants.BookPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.osgi.service.component.annotations.Component;
@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + BookPortletKeys.SUBTITLEPORTLET,
				"mvc.command.name=subtitle/create/view"
		})
public class SubtitleCreateRenderMvcCommand implements MVCRenderCommand{
    @Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		// TODO Auto-generated method stub
		return "/subtitle/create.jsp";
	}
}

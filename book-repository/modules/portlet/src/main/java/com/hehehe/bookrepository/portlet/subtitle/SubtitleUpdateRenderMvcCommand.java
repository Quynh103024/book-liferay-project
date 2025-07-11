package com.hehehe.bookrepository.portlet.subtitle;

import com.hehehe.bookrepository.portlet.constants.BookPortletKeys;
import com.hehehe.servicebuilder.service.SubtitleService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + BookPortletKeys.SUBTITLEPORTLET,
				"mvc.command.name=subtitle/update/view"
		},
		service = MVCRenderCommand.class)
public class SubtitleUpdateRenderMvcCommand implements MVCRenderCommand{
	@Reference
    private SubtitleService subtitleService;
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		// TODO Auto-generated method stub
		String subtitleId = ParamUtil.getString(renderRequest, "subtitleId");
		try {
			renderRequest.setAttribute("subtilte", subtitleService.getSubtitleById(subtitleId));
		} catch (PortalException e) {
			SessionErrors.add(renderRequest, "invalid-subtilte");
		}
		return "/subtitle/update.jsp";
	}
}

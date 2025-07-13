package com.hehehe.bookrepository.portlet.subtitle;

import com.hehehe.bookrepository.portlet.constants.BookPortletKeys;
import com.hehehe.servicebuilder.model.Subtitle;
import com.hehehe.servicebuilder.model.Book;
import com.hehehe.servicebuilder.service.SubtitleService;
import com.hehehe.servicebuilder.service.BookService;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + BookPortletKeys.SUBTITLEPORTLET,
        "mvc.command.name=subtitle/detail/view"
    },
    service = MVCRenderCommand.class
)
public class SubtitleDetailRenderMvcCommand implements MVCRenderCommand {

    @Reference
    private SubtitleService subtitleService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        String subtitleId = ParamUtil.getString(renderRequest, "subtitleId");

        try {
            Subtitle subtitle = subtitleService.getSubtitleById(subtitleId);
            renderRequest.setAttribute("subtitle", subtitle);

        } catch (Exception e) {
            SessionErrors.add(renderRequest, "subtitle-not-found");
        }

        return "/subtitle/details.jsp";
    }
}

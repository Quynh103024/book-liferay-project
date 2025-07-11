package com.hehehe.bookrepository.portlet.category;
import com.hehehe.bookrepository.portlet.constants.BookPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
@Component(
    immediate=true,
    property={
            "javax.portlet.name=" + BookPortletKeys.CATEGORYPORTLET,
            "mvc.command.name=category/create/view"
    }
)
public class CategoryCreateRenderMvcCommand implements MVCRenderCommand {
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		// TODO Auto-generated method stub
		return "/category/create.jsp";
	}
}

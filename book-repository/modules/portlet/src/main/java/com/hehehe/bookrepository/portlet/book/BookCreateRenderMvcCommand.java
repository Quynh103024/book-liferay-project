package com.hehehe.bookrepository.portlet.book;
import com.hehehe.bookrepository.portlet.constants.BookPortletKeys;
import com.hehehe.servicebuilder.service.AuthorService;
import com.hehehe.servicebuilder.service.CategoryService;
import com.hehehe.servicebuilder.service.SubtitleService;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + BookPortletKeys.BOOKPORTLET,
				"mvc.command.name=book/create/view"
		},
		service = MVCRenderCommand.class)
public class BookCreateRenderMvcCommand implements MVCRenderCommand {
	@Reference
	private CategoryService categoryService;
	@Reference
	private SubtitleService subtitleService;
	@Reference
	private AuthorService authorService;
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		// TODO Auto-generated method stub
		renderRequest.setAttribute("allAuthor", this.authorService.getAuthors());
		renderRequest.setAttribute("allCategory", this.categoryService.getCategories());
		renderRequest.setAttribute("allSubtitle", this.subtitleService.getSubtitles());
		return "/book/create.jsp";
	}
	
}

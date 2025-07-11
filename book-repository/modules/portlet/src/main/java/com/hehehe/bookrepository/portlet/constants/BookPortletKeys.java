package com.hehehe.bookrepository.portlet.constants;

public class BookPortletKeys {
	public static final String BOOKPORTLET = "com_hehehe_bookrepository_portlet_BookModulePortlet";
	public static final String AUTHORPORTLET = "com_hehehe_bookrepository_portlet_AuthorModulePortlet";
	public static final String SUBTITLEPORTLET = "com_hehehe_bookrepository_portlet_SubtitleModulePortlet";
	public static final String CATEGORYPORTLET = "com_hehehe_bookrepository_portlet_CategoryModulePortlet";
}

//package com.hehehe.bookrepository.portlet.portlet;
//
//import com.hehehe.bookrepository.portlet.constants.PortletPortletKeys;
//
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
//
//import javax.portlet.Portlet;
//
//import org.osgi.service.component.annotations.Component;
//
///**
// * @author Admin
// */
//@Component(
//	property = {
//		"com.liferay.portlet.display-category=category.sample",
//		"com.liferay.portlet.header-portlet-css=/css/main.css",
//		"com.liferay.portlet.instanceable=true",
//		"javax.portlet.display-name=Portlet",
//		"javax.portlet.init-param.template-path=/",
//		"javax.portlet.init-param.view-template=/view.jsp",
//		"javax.portlet.name=" + PortletPortletKeys.PORTLET,
//		"javax.portlet.resource-bundle=content.Language",
//		"javax.portlet.security-role-ref=power-user,user"
//	},
//	service = Portlet.class
//)
//public class PortletPortlet extends MVCPortlet {
//}
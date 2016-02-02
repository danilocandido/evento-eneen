import org.mentawai.template.ConventionController;
import org.mentawai.template.Page;

//		http://www.blacktie.co/2014/07/dashgum-free-dashboard/

public class TemplateManager extends org.mentawai.template.TemplateManager{

	Page base;
	
	@Override
	public void configurePages() {
		
		base = new Page(".*", "jsp/templates/templateAdmin.jsp", ConventionController.class);
		
		
//		base = new Page(".*", "jsp/templates/template.jsp", ConventionController.class);
//        base.setBlock("principal", new Page("jsp/templates/templateAdmin.jsp"));
//        base.setBlock("head", new Page("jsp/templates/head.jsp"));
//        base.setBlock("menu", new Page("menu.jsp"));
        add(base); 
		
	}
}

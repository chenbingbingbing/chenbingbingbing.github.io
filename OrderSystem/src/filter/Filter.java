package filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * ��������CJ1.C  VER 3.0��2017-12-10 
 * ��  �ܣ�������紫���е���������
 * ��ȫ�ȼ���2 �� 
 * ����ˣ��±���1789194307@qq.com 
 * �����ˣ��±���1789194307@qq.com
*/
/**
 * Servlet Filter implementation class Filter
 */
@WebFilter("/Filter")
public class Filter implements javax.servlet.Filter {
	String encoding=null;//������ʼ��
    /**
     * Default constructor. 
     */
    public Filter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		encoding=null;//��������Ϊ��
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		if(encoding!=null){
			request.setCharacterEncoding(encoding);//����request����ı���
			response.setContentType("text/html;charset="+encoding);//����response����ı���
			}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		encoding=fConfig.getInitParameter("encoding");//��ȡ��ʼ�ı���
	}

}

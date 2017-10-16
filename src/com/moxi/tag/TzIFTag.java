
package com.moxi.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 
 * 类名: TzIFTag
 * 创建人:lifan 
 * 时间：2017年7月17日 下午2:44:01 
 * @version 1.0.0
 *
 */
public class TzIFTag extends TagSupport{
	
	private Boolean test;

	public Boolean getTest() {
		return test;
	}

	public void setTest(Boolean test) {
		this.test = test;
	}

	@Override
	public int doStartTag() throws JspException {
		return EVAL_BODY_INCLUDE;//继续去执行标签提的内容
		//SKIP_BODY====默认值就是skip_body---忽略标签提直接进入doEndTag()
	}
	
}

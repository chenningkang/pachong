
package com.moxi.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 
 * 类名: TzThenTag
 * 创建人:lifan 
 * 时间：2017年7月17日 下午2:44:36 
 * @version 1.0.0
 *
 */
public class TzThenTag extends TagSupport{
	
	@Override
	public int doStartTag() throws JspException {
		TzIFTag parent = (TzIFTag)this.getParent();
		if(parent!=null && parent.getTest()){
			return EVAL_BODY_INCLUDE;//继续去执行标签提的内容
		}else{
			return SKIP_BODY;
		}
	}
	
//	tz:if
//	tz:elseif
//	tz:elseif
//	tz:else
}

package org.vgu.ocl2psql.ocl.impl;

import java.util.Collection;

import org.vgu.ocl2psql.ocl.context.CascadingOclContext;
import org.vgu.ocl2psql.ocl.context.OclContext;
import org.vgu.ocl2psql.ocl.exception.OclEvaluationException;
import org.vgu.ocl2psql.ocl.expressions.OclExpression;

public class OclIterateSupport {

    public static Object iterate(Collection<?> collection, OclContext context,
	    String iteratorName, String accuName, Object initAccu,
	    OclExpression body) throws OclEvaluationException {
	CascadingOclContext innerContext = new CascadingOclContext(context);
	for (Object it : collection) {
	    innerContext.setVariable(accuName, initAccu);
	    innerContext.setVariable(iteratorName, it);
	    initAccu = body.eval(innerContext);
	}
	return initAccu;
    }

}
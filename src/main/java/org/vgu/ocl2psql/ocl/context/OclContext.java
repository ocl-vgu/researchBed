/**************************************************************************
Copyright 2019 Vietnamese-German-University

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
***************************************************************************/

package org.vgu.ocl2psql.ocl.context;

import org.vgu.ocl2psql.ocl.exception.OclEvaluationException;

public interface OclContext {

    boolean isType(String typeName);

    boolean isEnum(String typeName);

    String getFullName(String typeName);

    Object getVariable(String name);

    Object getFieldValue(Object source, String propertyName) throws Exception;

    Object callMethod(Object source, String methodName,
	    Object... argumentValues) throws Exception;

    Object getType(String referredType) throws OclEvaluationException;
}
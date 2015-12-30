/*
 * Copyright (c) 2014, Cloudera, Inc. All Rights Reserved.
 *
 * Cloudera, Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"). You may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * This software is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for
 * the specific language governing permissions and limitations under the
 * License.
 */

package com.cloudera.oryx.lambda.serving;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.cloudera.oryx.api.serving.OryxServingException;

/**
 * Maps {@link OryxServingException} types to an HTTP {@link Response}.
 */
@Provider
public final class OryxExceptionMapper implements ExceptionMapper<OryxServingException> {

  @Override
  public Response toResponse(OryxServingException exception) {
    Response.ResponseBuilder response = Response.status(exception.getStatusCode());
    if (exception.getMessage() != null) {
      response = response.entity(exception.getMessage());
    }
    return response.build();
  }
}

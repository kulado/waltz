/*
 *  This file is part of Waltz.
 *
 *     Waltz is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Waltz is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Waltz.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.khartec.waltz.web.endpoints.api;

import com.khartec.waltz.service.capability.CapabilityService;
import com.khartec.waltz.web.endpoints.Endpoint;
import com.khartec.waltz.web.WebUtilities;
import com.khartec.waltz.web.endpoints.EndpointUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CapabilityEndpoint implements Endpoint {

    private static final String BASE_URL = WebUtilities.mkPath("api", "capability");

    private final CapabilityService service;


    @Autowired
    public CapabilityEndpoint(CapabilityService service) {
        this.service = service;
    }


    @Override
    public void register() {
        EndpointUtilities.getForList(WebUtilities.mkPath(BASE_URL), (request, response) ->  service.findAll());
        EndpointUtilities.getForList(WebUtilities.mkPath(BASE_URL, "search", ":query"), (request, response) ->  service.search(request.params("query")));
    }

}
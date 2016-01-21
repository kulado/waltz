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

import com.khartec.waltz.model.svg.SvgDiagram;
import com.khartec.waltz.service.svg.SvgDiagramService;
import com.khartec.waltz.web.ListRoute;
import com.khartec.waltz.web.endpoints.Endpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.khartec.waltz.web.WebUtilities.mkPath;
import static com.khartec.waltz.web.endpoints.EndpointUtilities.getForList;


@Service
public class SvgDiagramEndpoint implements Endpoint {

    private static final String BASE_URL = mkPath("api", "svg-diagram");

    private final SvgDiagramService svgDiagramService;

    @Autowired
    public SvgDiagramEndpoint(SvgDiagramService svgDiagramService) {
        this.svgDiagramService = svgDiagramService;
    }

    @Override
    public void register() {
        String findByKindPath = mkPath(BASE_URL, "kind", ":kind");

        ListRoute<SvgDiagram> findByKindRoute = (request, response) ->
                svgDiagramService.findByKind(request.params("kind"));

        getForList(findByKindPath, findByKindRoute);
    }
}
/*
 * Waltz - Enterprise Architecture
 * Copyright (C) 2016  Khartec Ltd.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import angular from "angular";
import {registerStores} from "../common/module-utils";
import changeLogStore from "./services/change-log-store";

export default () => {
    const module = angular.module('waltz.change.log', []);

    module
        .config(require('./routes'));

    registerStores(module, [
        changeLogStore
    ]);

    module
        .component('waltzChangeLogSection', require('./components/change-log-section'))
        .component('waltzChangeLogTable', require('./components/change-log-table'));

    return module.name;
};

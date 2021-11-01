import components from "./components"
import wrapComponents from "./wrap-components"
import * as authWrapActions from "./auth-extensions/wrap-actions"
import * as authActions from "./actions"
import authReducers from "./reducers"
import execute from "./execute";

export default function httpLoginAuthPlugin(toolbox) {

    let { fn } = toolbox

    fn.execute = (_ref) => {
        return execute(_ref, fn);
    };

    return {
        components,
        wrapComponents,
        statePlugins: {
            spec: {
            },
            auth: {
                wrapActions: authWrapActions,
                actions: authActions,
                reducers: authReducers
            }
        }
    }
}

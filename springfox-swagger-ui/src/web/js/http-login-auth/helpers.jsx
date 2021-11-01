import React from "react"

export function isOAS3(jsSpec) {
    const oasVersion = jsSpec.get("openapi")
    if(typeof oasVersion !== "string") {
        return false
    }
    return oasVersion.startsWith("3.0.") && oasVersion.length > 4
}

export function ComponentWrapFactory(Component) {
    return (Ori, system) => (props) => {
        if(system && system.specSelectors && system.specSelectors.specJson) {
            const spec = system.specSelectors.specJson()
            return <Component {...props} {...system} Ori={Ori}></Component>
        } else {
            console.warn("ComponentWrapFactory wrapper: couldn't get spec")
            return null
        }
    }
}

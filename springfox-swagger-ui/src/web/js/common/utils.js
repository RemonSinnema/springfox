import Im from "immutable"

const DEFAULT_RESPONSE_KEY = "default"

export function defaultStatusCode ( responses ) {
    let codes = responses.keySeq()
    return codes.contains(DEFAULT_RESPONSE_KEY) ? DEFAULT_RESPONSE_KEY : codes.filter( key => (key+"")[0] === "2").sort().first()
}

export function getAcceptControllingResponse(responses) {
    if(!Im.OrderedMap.isOrderedMap(responses)) {
        // wrong type!
        return null
    }

    if(!responses.size) {
        // responses is empty
        return null
    }

    const suitable2xxResponse = responses.find((res, k) => {
        return k.startsWith("2") && Object.keys(res.get("content") || {}).length > 0
    })

    // try to find a suitable `default` responses
    const defaultResponse = responses.get("default") || Im.OrderedMap()
    const defaultResponseMediaTypes = (defaultResponse.get("content") || Im.OrderedMap()).keySeq().toJS()
    const suitableDefaultResponse = defaultResponseMediaTypes.length ? defaultResponse : null

    return suitable2xxResponse || suitableDefaultResponse
}

export function createHtmlReadyId(id, replacement = "_") {
    return id.replace(/[^\w-]/g, replacement)
}

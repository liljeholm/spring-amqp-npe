package demo

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        url '/file'
    }
    response {
        status 200
        headers {
            contentType('text/plain')
            header(contentDisposition(), matching('attachment; filename="this_is_the_filename.txt"'))
        }
    }
}

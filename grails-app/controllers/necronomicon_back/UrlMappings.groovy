package necronomicon_back

class UrlMappings {

    static mappings = {
        delete "/$controller/$id(.$format)?"(action:"delete")
        get "/$controller(.$format)?"(action:"index")
        get "/$controller/$id(.$format)?"(action:"show")
        post "/$controller(.$format)?"(action:"save")
        put "/$controller/$id(.$format)?"(action:"update")
        patch "/$controller/$id(.$format)?"(action:"patch")

        "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')

        post "/auth"  (controller: "auth", action: "authenticate")
        get "/check/$studentId/$classId" (controller: "auth", action: "check")
        get "/add/$studentId/$classId" (controller: "auth", action: "addClass")
        get "/students/disciplines/$id" (controller: "auth", action: "disciplines")
        get "/verify/$studentId/$classId" (controller: "auth", action: "verifyClassAmout")


    }
}

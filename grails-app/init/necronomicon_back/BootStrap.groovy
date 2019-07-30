package necronomicon_back

import grails.gorm.transactions.Transactional

class BootStrap {
    def init = { servletContext ->
        def d1 = new Class(days: "Friday",discipline: "Data Sctructure", teacher: "Mr BirdPerson",amount: 10).save()
        def d2 = new Class(days: "Monday",discipline: "Artificial Inteligence",teacher: "Mr Hank", amount: 15).save()

        def student = new Student(name: 'Vicente Silva', email: 'vicente@gmail.com.br',
                username: 'vsilva', password: '123456', course: "Computer Science" ).save(failOnError: true)

        student.withTransaction{
            student.addToDisciplines(d1).save(flush:true)
        }

    }
    def destroy = {
    }
}

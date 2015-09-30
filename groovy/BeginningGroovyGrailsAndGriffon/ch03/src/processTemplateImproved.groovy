import groovy.text.SimpleTemplateEngine

Class.metaClass.getResourceAsText = { resource ->
    this.class.getResourceAsStream(resource).getText()
}
def emailTemplate = this.class.getResourceAsText('nightlyReportsEmail.gtpl')
def binding = [
        "user": new Expando([firstName: "Christopher", lastName: "Judd"]),
        "date": new Date()
]
def engine = new SimpleTemplateEngine()
def email = engine.createTemplate(emailTemplate).make(binding)
def body = email.toString()

println body
String.metaClass.fileAsString = {
    this.class.getResourceAsStream(delegate).getText()
}

println 'nightlyReportsEmail.gtpl'.fileAsString()

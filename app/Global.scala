import play.api.db.DB
import play.api.GlobalSettings
import play.api.Application
import slick.session.Session
import models._
import fixtures._
import play.Logger.{ debug, info, warn, error }

object Global extends GlobalSettings with SlickDriven {

  override def onStart(app: Application) {
    implicit val application = app

    lazy val database = getDb
    lazy val dal = getDal
    database.withSession {
      implicit session: Session =>
        dal.drop
        dal.create
    }
  }
}
/*
    database withSession {
      val ddl = Users.ddl ++ Sprints.ddl ++ Stories.ddl ++ Tasks.ddl
      info ("Creating Database Schema:" + ddl.createStatements.foldLeft("")(_+"\n"+_))
      ddl.create
      
      info ("Running DataFixtures...")
      UsersFixture.createFixtures
      ProjectsFixture.createFixtures
      SprintsFixture.createFixtures
      StoriesFixture.createFixtures
      // TasksFixture.createFixtures
    }*/ 
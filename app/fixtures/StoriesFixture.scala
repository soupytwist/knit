package fixtures

import java.sql.Timestamp

import models.DAL
import models.Priority
import models.Story
import repositories.SprintRepo
import repositories.StoryRepo

object StoriesFixture {
  def createFixtures = {

    val now = new java.util.Date()

    val asAdmin = "As an administrator, I want to "
    val asDev = "As a developer, I want to "

    val sprint1 = SprintRepo findById 1L get
    val sprint2 = SprintRepo findById 2L get

    StoryRepo.createAll(
      //    Id    Created                     Updated                     Sprint          Title              Description                        Status  Order  Priority          Points  Assignee
      Story(None, new Timestamp(now getTime), new Timestamp(now getTime), sprint1.id get, "Create Projects", asAdmin + "create a new project",  100,    1,     Priority.NORMAL,  2,      None),
      Story(None, new Timestamp(now getTime), new Timestamp(now getTime), sprint1.id get, "Create Sprints",  asAdmin + "create a new sprint",   200,    2,     Priority.NORMAL,  2,      None),
      Story(None, new Timestamp(now getTime), new Timestamp(now getTime), sprint1.id get, "Create Stories",  asAdmin + "create a new story",    100,    4,     Priority.NORMAL,  2,      Some(1)),
      Story(None, new Timestamp(now getTime), new Timestamp(now getTime), sprint1.id get, "Create Tasks",    asAdmin + "create a new task",     200,    3,     Priority.NORMAL,  3,      Some(2)),
      Story(None, new Timestamp(now getTime), new Timestamp(now getTime), sprint2.id get, "Create Tasks",    asDev + "create a new task",       100,    1,     Priority.NORMAL,  1,      None),
      Story(None, new Timestamp(now getTime), new Timestamp(now getTime), sprint2.id get, "Assign Task",     asDev + "assign a task to myself", 200,    2,     Priority.NORMAL,  2,      None))
  }
}
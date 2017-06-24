import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.type.TypeFactory
import com.project.kanban.domain.entity.card.Card
import spock.lang.Specification

class MappingTest extends Specification {

	def "aa"() {
		given:
//		CardStatus status = CardStatus.valueOf("in_progress".toUpperCase())

		String dataJson = "[{\"id\":6440,\"title\":\"Read the Book\",\"description\":\"I should read the **whole** book\",\"status\":\"TODO\",\"tasks\":[{\"id\":22614,\"name\":\"response\",\"done\":false},{\"id\":22613,\"name\":\"Mode data\",\"done\":false},{\"id\":22618,\"name\":\"more\",\"done\":true},{\"id\":22916,\"name\":\"英雄联盟\",\"done\":true}]},{\"id\":6505,\"title\":\"vivek\",\"description\":\"notjing\",\"status\":\"DONE\",\"tasks\":[]},{\"id\":6669,\"title\":\"132\",\"description\":\"132\",\"status\":\"DONE\",\"tasks\":[]},{\"id\":6689,\"title\":\"Study react\",\"description\":\"study react rout\",\"status\":\"DONE\",\"tasks\":[{\"id\":23443,\"name\":\"谷歌\",\"done\":false},{\"id\":23439,\"name\":\"百度\",\"done\":false}]},{\"id\":6441,\"title\":\"Write some code\",\"description\":\"Code along with the samples in the book at [github](https://github.com/pro-react)\",\"status\":\"DONE\",\"tasks\":[{\"id\":23075,\"name\":\"Study Pro-React book \",\"done\":false},{\"id\":22621,\"name\":\"Get lego architecture studio\",\"done\":false},{\"id\":22561,\"name\":\"My own experiments\",\"done\":false},{\"id\":22559,\"name\":\"ContactList Example\",\"done\":true},{\"id\":22560,\"name\":\"Kanban Example\",\"done\":false},{\"id\":22610,\"name\":\"Build a Lego\",\"done\":true},{\"id\":22908,\"name\":\"王者荣耀\",\"done\":false},{\"id\":23445,\"name\":\"赖宝\",\"done\":true}]},{\"id\":6624,\"title\":\"Write some code\",\"description\":\"Code along with the samples in the book at [github](https://github.com/pro-react)\",\"status\":\"DONE\",\"tasks\":[{\"id\":23442,\"name\":\"谷歌\",\"done\":false},{\"id\":23440,\"name\":\"百度\",\"done\":false},{\"id\":23441,\"name\":\"谷歌\",\"done\":false}]},{\"id\":6654,\"title\":\"Write some code\",\"description\":\"Code along with the samples in the book at [github](https://github.com/pro-react)\",\"status\":\"IN_PROGRESS\",\"tasks\":[{\"id\":23444,\"name\":\"百度\",\"done\":false}]}]"
		ObjectMapper mapper = new ObjectMapper()
		List<Card> value = mapper.readValue(dataJson, TypeFactory.defaultInstance().constructCollectionType(List.class, Card.class))

		print(value)

		expect:
		true
	}
}

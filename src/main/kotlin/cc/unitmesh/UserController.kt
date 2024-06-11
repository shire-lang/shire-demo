package cc.unitmesh

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController() {
    @GetMapping
    fun getUsers(): ResponseEntity<List<UserDTO>> {
        val listOf = listOf(UserDTO(1L, "username", "email", "name", "surname"))
        return ResponseEntity.ok(listOf)
    }
}

data class UserDTO(
    val id: Long? = null,
    val username: String,
    val email: String,
    val name: String,
    val surname: String? = null,
)

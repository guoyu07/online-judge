package com.hiczp.onlinejudge.shared.dao

import org.springframework.data.repository.CrudRepository
import java.io.Serializable
import javax.persistence.*

@Entity
data class Problem(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,

        @ManyToOne(optional = false)
        var problemSet: ProblemSet,

        @Column(nullable = false)
        var indexInProblemSet: Long,

        @Column(nullable = false, length = 64)
        var title: String,

        @Column(nullable = false, length = 16)
        @Enumerated(EnumType.STRING)
        var difficulty: Difficulty,

        @Column(nullable = false)
        @Lob
        var description: String,

        @Column
        @Lob
        var sampleInput: String,

        @Column
        @Lob
        var sampleOutput: String,

        @Column
        @Lob
        var input: String? = null,

        @Column
        @Lob
        var output: String
) : Serializable {
    enum class Difficulty {
        EASY,
        NORMAL,
        HARD
    }
}

interface ProblemRepository : CrudRepository<Problem, Long> {
    @Suppress("FunctionName")
    fun findByProblemSet_IdOrderByIndexInProblemSet(id: Long): List<Problem>
}

package com.hiczp.onlinejudge.runner.service

import com.hiczp.onlinejudge.runner.configuration.RunnerConfigurationProperties
import com.hiczp.onlinejudge.shared.dao.SubmitHistoryRepository
import com.hiczp.onlinejudge.shared.message.PendingSubmission
import org.springframework.stereotype.Service

@Service
class CJudgeService(runnerConfigurationProperties: RunnerConfigurationProperties,
                    submitHistoryRepository: SubmitHistoryRepository)
    : JudgeService(runnerConfigurationProperties, submitHistoryRepository) {
    override fun judgeAndSaveResult(pendingSubmission: PendingSubmission) {
        super.judgeAndSaveResult(pendingSubmission, sourceCodeFileName, compileCommand, runningCommand)
    }

    companion object {
        private const val sourceCodeFileName = "code.c"
        private val compileCommand = arrayOf("gcc", sourceCodeFileName)
        private const val elfFileName = "a.out"
        private val runningCommand = arrayOf("./$elfFileName")
    }
}

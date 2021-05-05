object SlackIncomingWebhookConstructor {
    fun getIncomingWebHook(ageLimit: Int, district: String): SlackIncomingWebHook {
        return when (district) {
            "BBMP" -> {
                if (ageLimit == 18) {
                    SlackIncomingWebHook("https://hooks.slack.com/services/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")
                } else {
                    SlackIncomingWebHook("https://hooks.slack.com/services/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")
                }
            }
            "Kolkata" -> {
                if (ageLimit == 18) {
                    SlackIncomingWebHook("https://hooks.slack.com/services/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")
                } else {
                    SlackIncomingWebHook("https://hooks.slack.com/services/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")
                }
            }
            "Pune" -> {
                if (ageLimit == 18) {
                    SlackIncomingWebHook("https://hooks.slack.com/services/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")
                } else {
                    SlackIncomingWebHook("https://hooks.slack.com/services/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")
                }
            }
            else -> {
                SlackIncomingWebHook("")
            }
        }
    }
}

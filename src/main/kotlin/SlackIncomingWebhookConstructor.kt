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

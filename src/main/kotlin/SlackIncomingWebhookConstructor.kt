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

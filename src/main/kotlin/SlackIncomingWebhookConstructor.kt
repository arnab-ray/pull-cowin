object SlackIncomingWebhookConstructor {
    fun getIncomingWebHook(ageLimit: Int): SlackIncomingWebHook {
        return if (ageLimit == 18) {
            SlackIncomingWebHook("https://hooks.slack.com/services/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")
        } else {
            SlackIncomingWebHook("https://hooks.slack.com/services/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")
        }
    }
}

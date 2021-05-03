object SlackIncomingWebhookConstructor {
    fun getIncomingWebHook(ageLimit: Int): SlackIncomingWebHook {
        return if (ageLimit == 18) {
            SlackIncomingWebHook("https://hooks.slack.com/services/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")
        } else {
            SlackIncomingWebHook("https://hooks.slack.com/services/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")
        }
    }
}

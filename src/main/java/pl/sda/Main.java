package pl.sda;

import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.model.block.ImageBlock;
import com.github.seratch.jslack.api.model.block.SectionBlock;
import com.github.seratch.jslack.api.model.block.composition.MarkdownTextObject;
import com.github.seratch.jslack.api.model.block.composition.PlainTextObject;
import com.github.seratch.jslack.api.model.block.element.ButtonElement;
import com.github.seratch.jslack.api.webhook.Payload;
import com.github.seratch.jslack.api.webhook.WebhookPayloads;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        Slack slack = Slack.getInstance();
        String channelUrl = "https://hooks.slack.com/services/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";

        ImageBlock imageBlock = ImageBlock.builder()
                .imageUrl("https://www.wyslijkwiaty.com/img/br019-7eed.jpg")
                .altText("obrazek")
                .build();

        MarkdownTextObject textUnderImage = MarkdownTextObject.builder().text("tekst pod obrazkiem").build();
        ButtonElement button = ButtonElement.builder()
                .text(PlainTextObject.builder().text(":heart:").build())
                .url("https://sdacademy.pl/")
                .build();
        SectionBlock sectionBlock = SectionBlock.builder()
                .text(textUnderImage)
                .accessory(button)
                .build();

        Payload payloadWithImage = WebhookPayloads.payload(payloadBuilder -> payloadBuilder.blocks(
                List.of(imageBlock, sectionBlock)
        ));
        slack.send(channelUrl, payloadWithImage);
        slack.close();
    }

}

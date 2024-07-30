package com.adhi.moviecrud.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp


//Component: Minimal Input Field

@Composable
fun MinimalInputField(
    value: String,
    onValueChange: (String) -> Unit,
    onUpdate: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "Add your note",
    textColor: Color = Color.White,
    cursorColor: Color = Color.Yellow
) {
    Box(
        modifier = modifier
    ) {
        BasicTextField(
            value = value,
            onValueChange = {
                onValueChange(it)
            },
            textStyle = TextStyle(color = textColor, fontFamily = FontFamily.SansSerif),
            cursorBrush = SolidColor(cursorColor),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .padding(16.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (value.isEmpty()) {
                        Text(
                            text = placeholder,
                            color = textColor.copy(alpha = 0.5f),
                            style = TextStyle(fontFamily = FontFamily.Monospace) // For a minimal feel
                        )
                    }
                    innerTextField()
                }
            }
        )
    }
}


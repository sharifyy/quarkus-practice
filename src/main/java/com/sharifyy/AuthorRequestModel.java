package com.sharifyy;

import io.quarkus.netty.BossEventLoopGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorRequestModel {
    private String name;
}

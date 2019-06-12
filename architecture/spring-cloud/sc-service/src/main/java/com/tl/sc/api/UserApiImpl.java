package com.tl.sc.api;

import com.tl.sc.common.api.UserApi;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tianlei
 * @date 2019/06/09
 */
@RestController
public class UserApiImpl implements UserApi {
    @Override
    public String getUserName(Long id) {
        return id + " - name";
    }
}

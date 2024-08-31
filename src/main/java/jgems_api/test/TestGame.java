/*
 * *
 *  * @author alfabouh
 *  * @since 2024
 *  * @link https://github.com/alfabouh/JavaGems3D
 *  *
 *  * This software is provided 'as-is', without any express or implied warranty.
 *  * In no event will the authors be held liable for any damages arising from the use of this software.
 *
 */

package jgems_api.test;

import javagems3d.engine.JGems3D;
import javagems3d.engine_api.app.JGemsGameInstance;
import jgems_api.test.events.TestEvents;
import jgems_api.test.manager.TestManager;
import jgems_api.test.resources.ModelLoader;
import org.jetbrains.annotations.NotNull;
import javagems3d.engine.JGemsHelper;
import javagems3d.engine.system.core.EngineSystem;
import javagems3d.engine.system.service.path.JGemsPath;
import javagems3d.engine_api.app.JGemsGameApplication;
import javagems3d.engine_api.app.JGemsGameEntry;
import javagems3d.engine_api.events.IAppEventSubscriber;
import javagems3d.engine_api.manager.AppManager;
import javagems3d.engine_api.resources.IAppResourceLoader;

@JGemsGameEntry(gameTitle = "Test", gameVersion = "0.1a", devStage = JGemsGameEntry.DevStage.PRE_ALPHA)
public class TestGame implements JGemsGameApplication {
    @JGemsGameInstance
    private static TestGame horrorGame;

    public TestGame() {
    }

    @Override
    public void loadResources(IAppResourceLoader appResourceLoader) {
        appResourceLoader.addAssetsLoader(new ModelLoader());
    }

    @Override
    public void subscribeEvents(IAppEventSubscriber appEventSubscriber) {
        appEventSubscriber.addClassWithEvents(TestEvents.class);
    }

    @Override
    public void preInitEvent(EngineSystem engineSystem) {
        JGems3D.DEBUG_MODE = true;
    }

    @Override
    public void postInitEvent(EngineSystem engineSystem) {
    }

    @Override
    public @NotNull AppManager createAppManager() {
        return new TestManager(null);
    }
}
